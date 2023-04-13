/*$(document).ready(function() {
    $('.edit-btn').click(function () {
        var festivalID = $(this).data('festival-id');
        $.ajax({
            type: 'GET',
            url: '/festivals/' + festivalID,
            success: function(festival) {
                //display festival details and allow editing
            },
            error: function () {
                alert('Error retrieving festival details');
            }
        });
    });
});*/

// La map Leaflet
let mymap = L.map('map').setView([48.202047, -2.932644], 8);
// Ajout d'un layer sur la map pour afficher des tuiles avec les routes
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    tileSize: 512,
    zoomOffset: -1,
    maxZoom: 18
}).addTo(mymap);
/**
 * Ajoute un marqueur sur la carte.
 *
 * @param {number} lat Latitude du marqueur.
 * @param {number} lon Longitude du marqueur.
 * @param {string} festivalName Le nom du festival à afficher dans la popup.
 * @param {string} festivalVille La ville du festival à afficher dans la popup.
 */
function addMarkerOnMap(lat, lon, festivalName, festivalVille) {

    // On ajoute une marque aux coordonnées fournies en paramètre
    var marker = L.marker([lat, lon]).addTo(mymap);

    // Un popup qui s'affichera au-dessus du marqueur
    let popup = L.popup().setContent(`<h2>${festivalName}</h2><h3>${festivalVille}</h3>`);
    marker.bindPopup(popup);
    marker.addEventListener('click', (event) => {
        popup.openOn(mymap);
    });
}

