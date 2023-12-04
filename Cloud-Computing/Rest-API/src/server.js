/* eslint-disable linebreak-style */
/* eslint-disable no-console */

const Hapi = require('@hapi/hapi');

async function init() {
  const server = Hapi.server({
    port: 8080,
    host: 'localhost',
  });

  await server.start();
  console.log(`Server berjalan pada ${server.info.uri}`);
}

init();
