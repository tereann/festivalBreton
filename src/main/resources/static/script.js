// La map Leaflet
let mymap = L.map('map').setView([48.202047, -2.932644], 8);
// Ajout d'un layer sur la map pour afficher des tuiles avec les routes
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    tileSize: 512,
    zoomOffset: -1,
    maxZoom: 18
}).addTo(mymap);


