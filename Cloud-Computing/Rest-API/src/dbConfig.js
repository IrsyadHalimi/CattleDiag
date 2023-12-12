const mysql = require('mysql');

const db = mysql.createConnection({
  host: '34.101.249.251',
  user: 'irsyad',
  password: 'irsyad123',
  database: 'cattle_diag',
});

module.exports = db;
