/* eslint-disable import/no-extraneous-dependencies */

const { nanoid } = require('nanoid');
const cattleSymptom = require('./cattleSymptom');

const addSymptomHandler = (request, h) => {
  const { cattle, desc } = request.payload;

  const id = nanoid(16);
  const createdAt = new Date().toISOString();
  const updatedAt = createdAt;

  const newSymptom = {
    cattle, desc, id, createdAt, updatedAt,
  };

  cattleSymptom.push(newSymptom);

  const isSuccess = cattleSymptom.filter((symptom) => symptom.id === id).length > 0;

  if (isSuccess) {
    const response = h.response({
      status: 'success',
      message: 'Gejala berhasil ditambahkan',
      data: {
        symptomId: id,
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

module.exports = { addSymptomHandler };
