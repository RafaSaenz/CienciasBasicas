/* 
 * AJAX functions for AdminPanel JSP and DataServlet
 */
// Show input for new topic
$(document).on("click", '#addNew', function (event) {
    $.get("/CienciasBasicas/DataServlet",
            {
                items: "topics_table",
                area: $("#addNew").attr('name'),
                mode: "input",
                newTopic: ""
            },
            function (data, status) {
                $("#cont1").html(data);
            });
    $("#cont1").show();
});
//Click on save
$(document).on("click", '#addNow', function (event) {
    if ($("#newTopic").val() != "") {
        $.get("/CienciasBasicas/DataServlet",
                {
                    items: "topics_table",
                    area: $("#area").val(),
                    mode: "add",
                    newTopic: $("#newTopic").val()
                },
                function (data, status) {
                    $("#newTopic").val("");
                    $("#cont2").html(data);
                });
    } else {
        alert("Empty");
    }
});
//Click on delete
$(document).on("click", '.delete-row', function (event) {
    $.get("/CienciasBasicas/DataServlet",
            {
                items: event.target.getAttribute('data-items'),
                area: event.target.getAttribute('data-area'),
                mode: event.target.getAttribute('data-mode'),
                newTopic: event.target.getAttribute('data-topic')
            },
            function (data, status) {
                $("#cont2").html(data);
            });
});
//Search table filtering
$(document).on("keyup", '#myInput', function (event) {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
//Loading content to modal
$(document).on("click", '.modalBtn', function (event) {
    $('.modal-body').load("/CienciasBasicas/DataServlet",
            {
                items: "topics_table",
                area: $("#addNew").attr('name'),
                mode: "edit",
                newTopic: event.target.getAttribute('data-topic')
            },
            function () {
                $('#myModal').modal({show: true});
            });
});
$(document).on("click", '.adminBtn', function (event) {
    $.get("/CienciasBasicas/DataServlet",
            {
                items: event.target.data('params'),
                area: "",
                mode: "",
                newTopic: ""
            },
            function (data, status) {
                $("#cont2").html(data);
            });
    $("#cont1").hide();
});
$(document).on("click", '#updateNow', function (event) {
    if ($("#newTopic").val() != "") {
        $.get("/CienciasBasicas/DataServlet",
                {
                    items: "topics_table",
                    area: $("#area").val(),
                    mode: "update",
                    newTopic: $("#newTopic").val(),
                    newId: $("#profile").val()
                },
                function (data, status) {
                    $("#cont2").html(data);
                    $('#myModal').hide();
                });
    } else {
        alert("Empty");
    }
});