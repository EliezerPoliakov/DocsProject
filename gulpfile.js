const { src, dest, series, parallel } = require('gulp');
const del = require('del');

const paths = {
  react_src: 'src/main/ui/build/**/*',
  react_dist: 'src/main/resources/static/'
};

function clean()  {
  return del('src/main/resources/static/**', {force:true});
}

function copyReactCodeTask() {
  return src(`${paths.react_src}`)
        .pipe(dest(`${paths.react_dist}`));
}

exports.default = series(
  clean,
  copyReactCodeTask
);