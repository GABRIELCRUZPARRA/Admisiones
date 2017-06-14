//fullpage.js
$(document).ready(function() {
    $('#fullpage').fullpage({
        //Navigation
        menu: '#menu',
        lockAnchors: true,
        anchors:['konrad', 'formulario', 'soporte'],
        navigation: true,
        navigationPosition: 'right',
        navigationTooltips: ['Bienvenidos', 'Formulario', 'Soporte'],
        showActiveTooltip: false,
        slidesNavigation: true,
        slidesNavPosition: 'bottom'
    });
});
