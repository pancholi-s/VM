import java.util.Scanner;
import mpi.*;

public class ArrReciprocal {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int unitsize = 5;
        int root = 0;
        int send_buffer[] = null;

        send_buffer = new int[unitsize * size];
        int recieve_buffer[] = new int[unitsize];
        double resultant_array[] = new double[unitsize * size];

        // Set data for distribution
        if (rank == root) {
            int total_elements = unitsize * size;
            System.out.println("Elements:");
            for (int i = 0; i < total_elements; i++) {
                send_buffer[i] = i + 1; // starting from 1 to avoid division by 0
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
            root
        );

        // Each process calculates reciprocal
        double local_reciprocal[] = new double[unitsize];
        for (int i = 0; i < unitsize; i++) {
            local_reciprocal[i] = 1.0 / recieve_buffer[i];
        }

        // Gather all reciprocals back at root
        MPI.COMM_WORLD.Gather(
            local_reciprocal,
            0,
            unitsize,
            MPI.DOUBLE,
            resultant_array,
            0,
            unitsize,
            MPI.DOUBLE,
            root
        );

        // Root displays resultant array
        if (rank == root) {
            System.out.println("Reciprocal Array:");
            for (int i = 0; i < unitsize * size; i++) {
                System.out.println("1 / " + send_buffer[i] + " = " + resultant_array[i]);
            }
        }

        MPI.Finalize();
    }
}
