# PSR - Network Systems Programming

This repository contains practical implementations developed during the *"Programmazione di Sistemi in Rete (PSR)"* (Network Systems Programming) course at **Università degli Studi del Sannio**. The project focuses on web systems programming with an emphasis on TCP and UDP socket communication in both **C** and **Java**. It includes examples of client-server architectures, concurrent connection handling, and data transmission over networks.

---

## 📑 Table of Contents
- [Project Overview](#project-overview)
- [Repository Structure](#repository-structure)
- [Requirements](#requirements)
- [Installation and Usage](#installation-and-usage)
  - [1. Clone the Repository](#1-clone-the-repository)
  - [2. Compile and Run (C Projects)](#2-compile-and-run-c-projects)
  - [3. Compile and Run (Java Projects)](#3-compile-and-run-java-projects)
- [Implemented Features](#implemented-features)
- [Testing and Results](#testing-and-results)
- [License](#license)
- [Acknowledgments](#acknowledgments)

---

## 📖 Project Overview
The **PSR** project aims to provide hands-on experience with network programming concepts and practical implementations. It covers:
- **TCP and UDP communication**
- **Client-server models** in both C and Java
- **Concurrent connections management** (e.g., multi-threaded servers)
- **Data serialization and transmission** techniques
- **Socket creation and management** in different scenarios (e.g., echo servers, file transfer applications)

This repository serves as a learning tool for understanding low-level network communication and building robust networked applications.

---

## 🗂️ Repository Structure
```
PSR/
├── C/
│   ├── tcp_server.c          # TCP server implementation in C
│   ├── tcp_client.c          # TCP client implementation in C
│   ├── udp_server.c          # UDP server implementation in C
│   ├── udp_client.c          # UDP client implementation in C
│   └── Makefile              # Build automation for C programs
├── Java/
│   ├── TCPServer.java        # TCP server implementation in Java
│   ├── TCPClient.java        # TCP client implementation in Java
│   ├── UDPServer.java        # UDP server implementation in Java
│   ├── UDPClient.java        # UDP client implementation in Java
├── tests/                    # Test scripts and sample data
├── results/                  # Execution logs and output files
├── LICENSE                   # Project license information
└── README.md                 # Project documentation
```

---

## ⚙️ Requirements
Ensure you have the following installed:
- **GCC** compiler (for C programs)
- **Java JDK** (version 8 or higher)
- **Make** (for compiling C projects)
- Terminal or command-line interface for running programs

### Install Dependencies (Ubuntu/Debian):
```bash
sudo apt update
sudo apt install build-essential default-jdk
```

---

## 🚀 Installation and Usage

### 1. Clone the Repository
```bash
git clone https://github.com/sroman0/PSR.git
cd PSR
```

### 2. Compile and Run (C Projects)
#### Compile all C programs:
```bash
cd C
make all
```
#### Run TCP Server and Client:
```bash
./tcp_server
./tcp_client
```
#### Run UDP Server and Client:
```bash
./udp_server
./udp_client
```

### 3. Compile and Run (Java Projects)
#### Navigate to the Java folder and compile:
```bash
cd ../Java
javac TCPServer.java TCPClient.java UDPServer.java UDPClient.java
```
#### Run TCP Server and Client:
```bash
java TCPServer
java TCPClient
```
#### Run UDP Server and Client:
```bash
java UDPServer
java UDPClient
```

---

## 💡 Implemented Features
- **TCP and UDP Servers/Clients**: Establish and manage connections.
- **Concurrent Servers**: Handle multiple clients simultaneously.
- **Reliable and Unreliable Data Transmission**: Demonstrate the differences between TCP and UDP.
- **File Transfer Applications**: Send and receive files over the network.
- **Error Handling**: Robust error detection and reporting.

---

## 🧪 Testing and Results
- Test scripts are available in the `tests/` directory.
- Execution results and logs can be found in the `results/` folder.
- Example test run:
```bash
./tests/test_tcp_connection.sh
./tests/test_udp_packet_loss.sh
```

---

## 📜 License
This project is licensed under the **GNU General Public License v3.0**.  
See the [LICENSE](https://github.com/sroman0/PSR/blob/main/LICENSE) file for details.

---

## 🙏 Acknowledgments
Developed during the *"Programmazione di Sistemi in Rete (PSR)"* course at **Università degli Studi del Sannio**.  
Special thanks to the instructors and classmates for their support and guidance.
