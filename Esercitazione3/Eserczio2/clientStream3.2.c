/*
 * clientStream.c
 *
 *  Created on: October 6, 2022
 *      Author: zimeo
 */

/*#include <sys/types.h>*/
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>


#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define PROTOPORT  5193  	/* Default server port number */
#define LOCALHOST "127.0.0.1" 	/* Default server address */


int main(int argc, char *argv[]) {
  struct  sockaddr_in sad; /* Struct to host the transport address of the remote socket */
  int     sd;              /* Socket descriptor              	  */
  int     port;            /* Port number                  		  */
  int     n;               /* Number of read bytes                */
  char    buf[1000];       /* Buffer for data reading and writing */
  char    *host;
  int flag=1;

  /* Create a socket for stream oriented communication */
  sd = socket(PF_INET, SOCK_STREAM, 0);
  if (sd < 0) {
      fprintf(stderr, "socket creation failed\n");
      exit(1);
  }

  /* Clean the memory area that will store the transport address of the remote socket (server) */
  memset((char *)&sad,0,sizeof(sad));

  /* Set the transport address of the remote socket (server)) */
  sad.sin_family = AF_INET;
  if (argc > 2) {
      port = atoi(argv[2]);
  } else {
      port = PROTOPORT;
  }
  if (port > 0)
      sad.sin_port = htons((u_short)port);
  else {
      fprintf(stderr,"bad port number %s\n", argv[2]);
      exit(1);
  }

  /* Check for the existence of an IP address on the command line */
  if (argc > 1) {
  	  host = argv[1]; /* if host argument is specified */
  } else {
  	  host = LOCALHOST;
  }

  sad.sin_addr.s_addr = inet_addr(host);

  /* Connect the local socket (sd) with the remote one identified by the transport address sad */
  if (connect(sd, (struct sockaddr *)&sad, sizeof(sad)) < 0) {
        fprintf(stderr,"connect failed\n");
        exit(1);
   }
    // Main chat loop
    while (1) {
        // Clear buffer
        memset(buf, 0, sizeof(buf));

        // Read user input
        printf("You: ");
        fgets(buf, sizeof(buf), stdin);

        // Check for termination command
        if (buf[strlen(buf)-2] == '.') {
            printf("Exiting chat.\n");
            break;
        }

        // Send message to server
        if (write(sd, buf, strlen(buf)) < 0) {
            perror("write failed");
            exit(EXIT_FAILURE);
        }

        // Read message from server
        if (read(sd, buf, sizeof(buf)) < 0) {
            perror("read failed");
            exit(EXIT_FAILURE);
        }

        // Print received message
        printf("Peer: %s", buf);
    }

    // Close socket
    close(sd);
    return 0;
}

