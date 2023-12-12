const Hapi = require('@hapi/hapi');
const routes = require('./routes');
const db = require('./dbConfig');

const init = async () => {
  const server = Hapi.server({
    port: 8080,
    host: process.env.NODE_ENV !== 'production' ? 'localhost' : '0.0.0.0',
    routes: {
      cors: {
        origin: ['*'],
      },
    },
  });

  server.route(routes);

  await db.connect(function (err) {
    if (err) throw err;
    console.log('Database Connected');
  });

  await server.start();
  console.log(`Server berjalan pada ${server.info.uri}`);
};

init();
