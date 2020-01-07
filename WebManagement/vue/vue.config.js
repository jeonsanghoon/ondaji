module.exports = {
  "outputDir": "../src/main/resources/static",
  "devServer": {
    "proxy": "http://localhost:8080"
  },
  "configureWebpack": {
    "devtool": "source-map"
  },
  "pages": {
    "index": {
      "entry": "src/main.js",
      "template": "public/index.html",
      "title": "index Page",
      "filename": "index.html"
    },
    "login": {
      "entry": "src/pages/home/login/login.js",
      "template": "public/pages/layout_blank.html",
      "title": "login Page",
      "filename": "./pages/home/login.html"
    },
    "templeate01": {
      "entry": "src/pages/temp/templeate01/templeate01.js",
      "template": "public/pages/layout_blank.html",
      "title": "templeate01 Page",
      "filename": "./pages/temp/templeate01.html"
    }
  },
  "transpileDependencies": [
    "vuetify"
  ]
}