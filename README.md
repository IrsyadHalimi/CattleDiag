# CattleDiag
CattleDiag is an application created by the CH2-PR603 cohort Bangkit Academy 2023 for the capstone project. CattleDiag is an application to help farmers identify diseases in their livestock by identifying the symptoms entered. After inputting the symptoms of livestock animals, they are then analyzed, providing information on what disease they are experiencing, and not only that, CattleDiag also provides information on how to cure it.

# Group ID: CH2-PR603
Team Members:

- Rafly Ade Kusuma       A200BSY2188   Mobile Development    
- Galih Kuncoro Jati     M248BSY1167   Machine Learning    
- Zahran Aris Hanafi     M322BSY0144   Machine Learning    
- Ibnu Hasan             C256BSY3118   Cloud Computing     
- Irsyad Halimi          C193BSY3779   Cloud Computing     
- Adjie Fauzan Muttaqin  C491BSY4142   Cloud Computing     

# Project Plan Document
[Link Project Plan](https://docs.google.com/document/d/1PMCEKqtCIhXkZkfvbOby7mso87_mXo0LEJmka7PsVAE/edit)

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
