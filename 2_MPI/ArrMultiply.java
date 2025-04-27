import java.util.Scanner;
import mpi.*;

public class ArrMultiply {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        // 1 process is expected to handle 5 elements

        int unitsize = 5;
        int root = 0;
        int send_buffer[] = null;

        send_buffer = new int[unitsize * size];
        int recieve_buffer[] = new int[unitsize];
        int new_recieve_buffer[] = new int[size];

        // Set data for distribution
        if (rank == root) {
            int total_elements = unitsize * size;
            System.out.println("Elements:");
            for (int i = 0; i < total_elements; i++) {
                send_buffer[i] = i + 1; // starting from 1 to avoid 0 multiplication
                System.out.println("Element " + i + " = " + send_buffer[i]);
            }
        }

        // Scatter data to processes
        MPI.COMM_WORLD.Scatter(
                send_buffer,
                0,
                unitsize,
                MPI.INT,
                recieve_buffer,
                0,
                unitsize,
                MPI.INT,
                root);

        // Calculate multiplication at each process
        // Store result in first index of array
        for (int i = 1; i < unitsize; i++) {
            recieve_buffer[0] *= recieve_buffer[i];
        }
        System.out.println(
                "Intermediate product at process " + rank + " is " + recieve_buffer[0]);

        // Gather products from all processes
        MPI.COMM_WORLD.Gather(
                recieve_buffer,
                0,
                1,
                MPI.INT,
                new_recieve_buffer,
                0,
                1,
                MPI.INT,
                root);

        // Final product at root
        if (rank == root) {
            int total_product = 1;
            for (int i = 0; i < size; i++) {
                total_product *= new_recieve_buffer[i];
            }
            System.out.println("Final product : " + total_product);
        }

        MPI.Finalize();
    }
}
