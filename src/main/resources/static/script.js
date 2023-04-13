$(document).ready(function() {
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
});

