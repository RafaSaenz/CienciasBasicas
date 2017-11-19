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
                items: "topics_table",
                area: $("#addNew").attr('name'),
                mode: "delete",
                newTopic: event.target.getAttribute('data-topic')
            },
            function (data, status) {
                $("#cont2").html(data);
            });
});
//Click on edit
