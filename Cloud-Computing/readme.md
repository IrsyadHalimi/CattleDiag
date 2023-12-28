Node.js
v18.16.0

Hapi framework
v21.3.2

packages: nodemon, nanoid@3.x.x, joi, mysql
--------------------------------------------

# Cloud/Backend Documentation

This is the backend documentation section of CattleDiag, encompassing a Rest API project utilizing the Hapi Framework Node.JS, and several Google Cloud services used, such as Google Compute Engine, Cloud SQL MySQL, and Cloud Storage






## API Reference

#### Get all symptom

```http
  GET /symptoms
```

#### Get all desease

```http
  GET /deseases
```

#### Diagnose Cattle Desease

```http
  POST /diagnose
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `animalId`, `symptomDesc`      | `string` | **Required** |



### Deployment on Google Cloud Platform

Create Service Account
- Open Google Cloud Console
- Open IAM & Admin from the sidebar
- Select the 'Service accounts' menu, Click on 'Create service account'
- Fill in the service account name, click 'Create and continue'
- Choose the roles 'Cloud SQL Client' and 'Cloud Storage Admin' for the VM API connection with Cloud SQL and Cloud Storage
- Click 'Continue', then click 'Done'

Create Compute Engine
- Click on 'VM instances', then click 'Create instance' Fill in the VM name
- Choose the region and zone
- Select the machine type configuration according to requirements
- Under the 'Network interface' section, choose 'Default' for network, select 'IPv4' for IP stack type, create a static IP for the external IPv4 address
- Under the 'Firewall' section, select 'Allow HTTP' and 'Allow HTTPS'
- Choose the previously created service account"

Create Cloud SQL MySQL
- Open SQL from the sidebar
- Click on 'Create instance', then choose 'MySQL'
- Fill the instance ID, Enter the password, Select MySQL version 8.0
- Choose the region
- Click on 'Show configuration options'
- Click on 'Connections', select 'Public IP', then click 'Add a network'
- Fill in the network name, input the network with the Public IP from the Compute Engine VM API, then click 'Done'
- Click 'Create Instance'
- Click on the created instance ID
- Click 'Open Cloud Shell'
- Create a database, create a table, insert data"

Learn more in Google Cloud Official Documentation

https://cloud.google.com/sql/docs/mysql/connect-compute-engine

https://cloud.google.com/sql/docs/mysql/samples/cloud-sql-mysql-mysql-connection



## Run API in Locally
Ensure that Node.js version is installed, equal to or greater than 16.x.x.

Open terminal, then execute command below

```bash
  git clone https://github.com/IrsyadHalimi/CattleDiag.git

```
```bash
  cd CattleDiag/Cloud-Computing/Rest-API
```
```bash
  npm install
```
```bash
  npm run start-dev
```
    
