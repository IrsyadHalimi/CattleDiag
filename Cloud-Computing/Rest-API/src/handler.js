const { nanoid } = require('nanoid');
const db = require('./dbConfig');

const addSymptom = async (request, h) => {
  const { symptomDesc } = request.payload;
  const symptomId = nanoid(6);
  const created = new Date().toISOString();
  const updated = created;

  // call ML model
  // return diagnose

  if (symptomDesc) {
    const id = symptomId;
    const description = symptomDesc;
    const createdAt = created.slice(0, 19).replace('T', ' ');
    const updatedAt = updated.slice(0, 19).replace('T', ' ');
    const sql = await `INSERT INTO symptom (id, description, createdAt, updatedAt) VALUE ('${id}', '${description}', '${createdAt}', '${updatedAt}')`;
    db.query(sql, (err, result) => {
      if (err) {
        console.log('error insert data', err);
        response.code(500);
        return response;
      }
    });
    const response = h.response({
      status: 'success',
      message: 'Gejala berhasil ditambahkan',
      data: {
        id: symptomId,
      },
    });
    response.code(201);
    return response;
  }

  const response = h.response({
    status: 'fail',
    message: 'Gejala gagal ditambahkan',
  });
  response.code(500);
  return response;
};

const getAllSymptom = async (request, h) => {
  const sql = await new Promise((resolve, reject) => {
    db.query('SELECT * FROM symptom', (err, result) => {
      if (err) {
        reject(err);
      }
      resolve(result);
    });
  });
  return h.response(sql).code(201);
};

module.exports = { addSymptom, getAllSymptom };
