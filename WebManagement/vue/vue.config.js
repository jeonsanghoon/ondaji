/* eslint-disable no-irregular-whitespace */
module.exports = {  
      outputDir: "../src/main/resources/static",  
        // eslint-disable-next-line no-irregular-whitespace
      devServer: {  
        proxy: "http://localhost:8080"  
      },  
      chainWebpack: config => {  
    // eslint-disable-next-line no-irregular-whitespace
        const svgRule = config.module.rule("svg");    
        svgRule.uses.clear();    
        svgRule.use("vue-svg-loader").loader("vue-svg-loader");  
      },pages : {
        index: {
            entry: 'src/main.js', //entry for the public page
            template: 'public/index.html', // source template
            title:'index Page',
            filename: 'index.html' // output as dist/*
          },
          login: {
            entry: 'src/pages/home/login/login.js',
            template: 'public/pages/login.html',
            title:'login Page',
            filename: './pages/home/login.html'
          }
    }  
};