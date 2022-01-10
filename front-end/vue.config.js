const path = require('path')
const webpack = require('webpack')

module.exports = {
    configureWebpack: {
        resolve: {
            alias: {
                '@': path.join(__dirname, 'src/'),
                '~': path.join(__dirname, 'src/')
            }
        }
    }
}