const mysql = require('mysql');

const db = mysql.createConnection({
  host: 'localhost',
  port: '',
  database: 'cattle_diag',
  user: 'root',
  password: '',
});

module.exports = db;
