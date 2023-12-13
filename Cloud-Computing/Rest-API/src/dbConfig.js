const mysql = require('mysql');

const db = mysql.createConnection({
  host: '127.0.0.1',
  port: 'cloudsql_port',
  database: 'your_database',
  user: 'user_database',
  password: 'password_database',
});

module.exports = db;
