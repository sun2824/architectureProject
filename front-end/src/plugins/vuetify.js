import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    breakpoint: {
        mobileBreakpoint: 'xs'
    },
    theme: {
        dark: false,
        themes: {
            light: {
                sideBar: '#061238',
                white: '#FFFFFF'
            }
        }

    }
});
