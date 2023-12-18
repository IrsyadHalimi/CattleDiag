const { nanoid } = require('nanoid');
const db = require('./dbConfig');

const addSymptom = async (request, h) => {
  try {
    const { animalId, symptomDesc } = request.payload;
    const symptomId = nanoid(6);
    const created = new Date().toISOString();
    const updated = created;
    
    const query = `INSERT INTO symptom (id, animal_id, description, createdAt, updatedAt) VALUE (?, ?, ?, ?, ?)`;
    const result = await executeQuery(query, [symptomId, animalId, symptomDesc, created, updated]);
    
    const query2 = `SELECT * FROM desease WHERE animal_id = ? LIMIT 1`;
    const result2 = await executeQuery(query2, [animalId]);
    
    return h.response({
      message: 'Data added successfully',
      searchData: result2
    });
  } catch (error) {
    return h.response({ error: error.message }).code(500);
  }
};

const getAllSymptom = async (request, h) => {
  try {
    const query = 'SELECT * FROM symptom';
    const data = await executeQuery(query);
    return h.response(data);
  } catch (error) {
    return h.response({ error: error.message }).code(500);
  }
};

const getAllDesease = async (request, h) => {
  try {
    const query = 'SELECT * FROM desease';
    const data = await executeQuery(query);
    return h.response(data);
  } catch (error) {
    return h.response({ error: error.message }).code(500);
  }
};

const executeQuery = (query, params = []) => {
  return new Promise((resolve, reject) => {
    db.query(query, params, (error, results) => {
      if (error) {
        reject(error);
        return;
      }
      resolve(results);
    });
  });
};

module.exports = { addSymptom, getAllSymptom, getAllDesease };
