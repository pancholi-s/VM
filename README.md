Pre-requisites:

1.
    JDK-8

    sudo apt-get remove openjdk*
    sudo apt update
    sudo apt install openjdk-8-jdk openjdk-8-jre
    java -version
    // it should have version start with 1.8... etc
~~

2.
    Download MPJ Express & extract it in Downloads
    (https://sourceforge.net/projects/mpjexpress/files/releases/mpj-v0_44.tar.gz/download)
~~

3.
    Install Apache Netbeans (It will be Easier to work with Netbeans on Windows than Ubuntu)
    Download NetBeans 8.2 With Glassfish 4.1.1
    (https://drive.google.com/file/d/1Cg3Tn8ALQlrFyEGO3e6lH4h8cvECDylu/view?usp=sharing)

                To Install :
                sudo bash [file_name.sh]
    *** For Jdk Path in setup Enter Path from :/usr/lib/jvm/[jdk] In my Case : /usr/lib/jvm/java-8-openjdk-amd64 Glassfish server version must be 4.1.1

    Windows: NetBeans for Windows 8.2
    (https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqazNzTWYtMG93eUMwXzJHb2RDRm1KaFp1YlRyUXxBQ3Jtc0ttWWpvRHZHZzM4MUNYRndTaUxwRUxVUVltZU1PSWZ4X0dPRUZxU0NMWEE1SzlCMk5TVlhMN2R4R2pxSFpDODdhUlJsUVJUTXc4QTN2cWlIaE5oMWVKWGliTTZUUm1ueFFTNE5xeG51NUVFRnJtS25LRQ&q=https%3A%2F%2Fbit.ly%2F3MMVGTe&v=ASd1S-_HLWw)
~~


REMOVE COPY WORD FROM EACH FILE NAME IF THERE ANY.
~~

Assignment 1:

    Terminal:
        sudo apt install net-tools
        ip a
        // copy ip after inet (inet 127.0.0.1/8 scope host lo) -> 127.0.0.1

    Terminal 1:
        javac *.java
        rmic AddServerImpl

    Terminal 2:
        rmiregistry

    Terminal 3:
        java AddServer

    Terminal 4:
        java AddClient 127.0.0.1 5 8
            // The Arguments (2 numbers, 1 word, etc., etc.) are specified after localhost address (from "ip a").


Assignment 2: (Specify Path Properly Don't Just Copy Paste the Command of extracted)

    Terminal:
        export MPJ_HOME=/home/ubuntu/Downloads/mpj-v0_44

        export PATH=$MPJ_HOME/bin:$PATH

        javac -cp $MPJ_HOME/lib/mpj.jar ArrSum.java
        // put correct name .java

        $MPJ_HOME/bin/mpjrun.sh -np 4 ArrSum
        // Specified value of n=4 here


Assignment 3: (if You are getting error in this or next assignment then issue is with Java Version it works with Java 8 only as it is depreciated after Java 8 :)

    Terminal 1:
        idlj -fall ReverseModule.idl
        javac *.java ReverseModule/*.java
        orbd -ORBInitialPort 1056 &
        java ReverseServer -ORBInitialPort 1056 &

    Terminal 2:
        java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost


Assignment 4:

    Terminal:
        python3 --version
        sudo apt update
        sudo apt install python3
        python3 --version

    Terminal 1:
        python3 server.py
        // python server.py

    Terminal 2:
        python3 client.py
        // python client.py


Assignment 5:

    Terminal:
        javac Tring.java
        java Tring


Assignmnet 6:
    Terminal 1:
        javac Bully.java
        java Bully

    Terminal 2:
        javac Ring.java
        java Ring


Assignment 7:
    