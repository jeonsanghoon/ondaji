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
        }
    },
    "transpileDependencies": [
        "vuetify"
    ]
}