# **Flight Management System (FMS)**

## Table of Contents

1. [Description](#description)
2. [Prerequisites](#prerequisites)
3. [Features](#features)
4. [Installation Instructions](#installation-instructions)
5. [Usage](#usage)
6. [Dependencies](#dependencies)

## Description

**FMS** is a CLI application that enables user to create and manage booking flight.

## Prerequisites

The project prerequisites is as stated follow:

- Ensure **Git** is installed
- **Java**: v21.0.7
- **Maven**: 3.6.0

## Features

- User authentication (login for admin and passenger)
- Create Aircraft
- Create Destination
- Create Flight Route
- Passenger Booking Management 

## Installation Instructions

To set up **FMS** on your local machine:

1. Clone the repository:

   ```bash
   git clone https://github.com/RahmawatiSitti-Azizah/FlightManagementSystem-RnD.git
   cd FlightManagementSystem-RnD
   ```
2. Run via Docker:
    Make sure you installed docker and docker compose in your computer and open cmd/powershell/bash go to the root of the extracted folder

   ```bash
   docker-compose run --rm app <cmd/ps/bash>
   ```

## Usage

After the application is running:

Start exploring the application with logging in with registered user account. Please refer to ![database](src\main\resources\data.sql)

## Dependencies

The project uses the following key libraries:

- **JPA**: provide integration with database
- **Lombok**: Reduces boilerplate with auto generated codes
- **H2 Database**: Database engine

You can view the full list of dependencies in the `pom.xml` file.
