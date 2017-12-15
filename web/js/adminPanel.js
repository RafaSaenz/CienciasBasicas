$(document).on("click", "#man-tas", function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Areas",
            {
                action: "select"
            },
            function (data, status) {
                var x = "";
                for (i in data) {
                    x += "<li><a href=# id='" + data[i].id + "' class='area-link'>" + data[i].area + "</a></li>\n";
                }
                $("#top_sub").html(x);
            });
});
/*
 **** ------ TYPES ------ ****
 */
function showTypes() {
    $.get("/CienciasBasicas/ResTypes",
            {
                action: "show"
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on area to show topics table
$(document).on("click", '#man-types', function (event) {
    event.preventDefault();
    showTypes();
});
/*
 **** ------ END OF TYPES ------ ****
 */
/*
 **** ------ AREAS ------ ****
 */
//Show topics table
function showAreas() {
    $.get("/CienciasBasicas/Areas",
            {
                action: "show"
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on area to show topics table
$(document).on("click", '#man-area', function (event) {
    event.preventDefault();
    showAreas();
});
// Show input for new area
$(document).on("click", '#add-area', function (event) {
    $("#area-input").show();
    $("#area-edit").hide();
});
// Save new area
$(document).on("click", '#save-area', function (event) {
    event.preventDefault();
    if ($("#area-name").val() !== "" && $("#area-id").val() !== "") {
        $.get("/CienciasBasicas/Areas",
                {
                    action: "add",
                    area: $("#area-name").val(),
                    id: $("#area-id").val().toUpperCase()
                },
                function (data, status) {
                    $("#area-name").val("");
                    $("#area-id").val("");
                    showAreas();
                    $("#area-input").show();
                    $("#area-edit").hide();
                });
    } else {
        alert("Debe escribir el nombre del tema");
    }
});
//Enable/Disable an area
$(document).on("click", '.enable-btn5', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Areas",
            {
                area: $(event.target).closest('tr').attr('id'),
                action: event.target.getAttribute('name')
            },
            function (data, status) {
                showAreas();
            });
});
// Show input for editing an area
$(document).on("click", '.edit-btn3', function (event) {
    $("#area-edit").show();
    $("#area-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    var tmp2 = $(event.target).parent().parent().siblings(":nth-child(2)").text();
    $("#edit-area").val(tmp);
    $("#update-area").data("id", tmp2);
});
// Update the area
$(document).on("click", '#update-area', function (event) {
    event.preventDefault();
    if ($("#edit-area").val() !== "") {
        $.get("/CienciasBasicas/Areas",
                {
                    action: "update",
                    id: $("#update-area").data('id'),
                    area: $("#edit-area").val()
                },
                function (data, status) {
                    showAreas()
                });
    } else {
        alert("Empty");
    }
});
// Deletion of an area
$(document).on("click", '.delete-btn', function (event) {
    event.preventDefault();
    var area = $(event.target).parent().parent().siblings(":first").text();
    if (confirm("¿Está seguro de eliminar el área " + area + "? Dicha acción no podrá revertirse.")) {
        $.get("/CienciasBasicas/Areas",
                {
                    action: "delete",
                    id: $(event.target).closest('tr').attr('id'),
                },
                function (data, status) {
                    $("#cont2").html(data);
                });
    }
});
/*
 **** ------ END OF AREAS ------ ****
 */
/*
 **** ------ TOPICS ------ ****
 */
//Boostrap topics table filtering
$(document).on("keyup", '#myTopic', function (event) {
    var value = $(this).val().toLowerCase();
    $("#myTopicTbl tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
//Show topics table
function showTopics(area) {
    $.get("/CienciasBasicas/Topics",
            {
                action: "show",
                area: area
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on area to show topics table
$(document).on("click", '.area-link', function (event) {
    event.preventDefault();
    showTopics(event.target.getAttribute('id'));
});
// Show input for new topic
$(document).on("click", '#add-topic', function (event) {
    $("#topic-input").show();
    $("#topic-edit").hide();
});
// Save new topic
$(document).on("click", '#save-topic', function (event) {
    event.preventDefault();
    if ($("#topic").val() !== "") {
        $.get("/CienciasBasicas/Topics",
                {
                    area: $("#add-topic").attr('name'),
                    action: "add",
                    id: $("#topic").val()
                },
                function (data, status) {
                    $("#topic").val("");
                    showTopics($("#add-topic").attr('name'));
                    $("#topic-input").show();
                    $("#topic-edit").hide();
                });
    } else {
        alert("Debe escribir el nombre del tema");
    }
});
//Enable/Disable a Topic
$(document).on("click", '.enable-btn', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Topics",
            {
                area: $("#add-topic").attr('name'),
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showTopics($("#add-topic").attr('name'));
            });
});
// Show input for editing a topic
$(document).on("click", '.edit-btn', function (event) {
    $("#topic-edit").show();
    $("#topic-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    var tmp2 = $(event.target).parent().parent().siblings(":nth-child(2)").text();
    $("#edit-topic").val(tmp);
    $("#update-topic").data("id", tmp2);
});
// Update the topic
$(document).on("click", '#update-topic', function (event) {
    event.preventDefault();
    if ($("#edit-topic").val() !== "") {
        $.get("/CienciasBasicas/Topics",
                {
                    area: $("#add-topic").attr('name'),
                    action: "update",
                    id: $("#update-topic").data('id'),
                    name: $("#edit-topic").val()
                },
                function (data, status) {
                    showTopics($("#add-topic").attr('name'));
                });
    } else {
        alert("Empty");
    }
});
/*
 **** ------ END OF TOPICS ------ ****
 */
/*
 **** ------ SUBTOPICS ------ ****
 */
//Boostrap subtopics table filtering
$(document).on("keyup", '#mySubtopic', function (event) {
    var value = $(this).val().toLowerCase();
    $("#mySubtopicTbl tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
// Function to get subtopics table
function showSubtopics(topic) {
    $('.modal-body').load("/CienciasBasicas/Subtopics",
            {
                action: "show",
                topic: topic
            },
            function () {
                $('#myModal').modal({show: true});
            });
}
// Show subtopics table on modal
$(document).on("click", '.modalBtn', function (event) {
    event.preventDefault();
    var tmp = $(event.target).closest('tr').attr('id');
    showSubtopics(tmp);
});
// Show input for new subtopic
$(document).on("click", '#add-subtopic', function (event) {
    $("#subtopic-input").show();
    $("#subtopic-edit").hide();
});
// Save new subtopic
$(document).on("click", '#save-subtopic', function (event) {
    event.preventDefault();
    if ($("#subtopic").val() !== "") {
        $.get("/CienciasBasicas/Subtopics",
                {
                    topic: $("#add-subtopic").attr('name'),
                    action: "add",
                    id: $("#subtopic").val()
                },
                function (data, status) {
                    $("#subtopic").val("");
                    showSubtopics($("#add-subtopic").attr('name'));
                    $("#subtopic-input").show();
                    $("#subtopic-edit").hide();
                });
    } else {
        alert("Debe escribir el nombre del subtema");
    }
});
//Enable/Disable a Subtopic
$(document).on("click", '.enable-btn2', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Subtopics",
            {
                topic: $("#add-subtopic").attr('name'),
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showSubtopics($("#add-subtopic").attr('name'));
            });
});
// Show input for editing a subtopic
$(document).on("click", '.edit-btn2', function (event) {
    $("#subtopic-edit").show();
    $("#subtopic-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    var tmp2 = $(event.target).parent().parent().siblings(":nth-child(2)").text();
    $("#edit-subtopic").val(tmp);
    $("#update-subtopic").data("id", tmp2);
});
// Update the subtopic
$(document).on("click", '#update-subtopic', function (event) {
    event.preventDefault();
    if ($("#edit-subtopic").val() !== "") {
        $.get("/CienciasBasicas/Subtopics",
                {
                    topic: $("#add-subtopic").attr('name'),
                    action: "update",
                    id: $("#update-subtopic").data('id'),
                    name: $("#edit-subtopic").val()
                },
                function (data, status) {
                    showSubtopics($("#add-subtopic").attr('name'));
                });
    } else {
        alert("Empty");
    }
});
/*
 **** ------ END OF SUBTOPICS ------ ****
 */
/*
 **** ------ RESOURCES ------ ****
 */
//Show resources table
function showResources() {
    $.get("/CienciasBasicas/Resources",
            {
                action: "view",
                mode: "table"
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on resources to show reources table
$(document).on("click", '#man-res', function (event) {
    event.preventDefault();
    showResources();
});
//Enable/Disable a Resource
$(document).on("click", '.enable-btn3', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/DataServlet",
            {
                items: "resources",
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showResources();
            });
});
// Updating a resource
$(document).on("click", '.edit-btn-r', function (event) {
    event.preventDefault();
    var tmp = $(event.target).closest('tr').attr('id');
    $.get("/CienciasBasicas/Resources",
            {
                action: "edit-form",
                r_id: tmp
            },
            function (data, status) {
                $('.modal-body').html(data);
                $('.modal-title').html('Editar recurso:');
                $('.btn-default').html('<i class="fa fa-floppy-o"></i> Guardar Cambios');
                $('#adminModal').modal({show: true});
            });
});
// Updating files
$(document).on("click", '.edit-btn-f', function (event) {
    event.preventDefault();
    var tmp = $(event.target).closest('tr').attr('id');
    $.get("/CienciasBasicas/Resources",
            {
                action: "edit-form2",
                r_id: tmp
            },
            function (data, status) {
                $('.modal-body').html(data);
                $('.modal-title').html('Manejo de materiales:');
                $('.btn-default').html('<i class="fa fa-floppy-o"></i> Guardar Cambios');
                $('.input-row').hide();
                $('#adminModal').modal({show: true});
            });
});
$(document).on("click", '#edit-btn-i', function (event) {
    event.preventDefault();
    $(event.target).closest('.input-row').show();
});
/*
 **** ------ END OF RESOURCES ------ ****
 */


/*
 **** ------ INSTRUCTORS ------ ****
 */
//Show instructors table
function showInstructors() {
    $.get("/CienciasBasicas/Instructors",
            {
                action: "view",
                mode: "table",
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on instructors to show instructors table
$(document).on("click", '#man-ins', function (event) {
    event.preventDefault();
    showInstructors();
});
//Enable/Disable an Instructor
$(document).on("click", '.enable-btn4', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Instructors",
            {
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showInstructors();
            });
});
//Modify an Instructor
/*
 $(document).on("click", '#edit-btn4', function (event) {
 event.preventDefault();
 $.get("/CienciasBasicas/Instructors",
 {
 action: "add",
 id: $("#edit-btn4").data('id'),
 //name: $("#edit-subtopic").val()
 },
 function (data, status) {
 showInstructors();
 });
 
 });*/

/*
 **** ------ END OF INSTRUCTORS ------ ****
 */

/*
 **** ------ SELECTS FOR RESOURCE UPDATING ------ ****
 */
$(document).on("change", "#area-slct", function (event) {
    $("#topic-slct").empty();
    $("#subtopic-slct").empty();
    $.get("/CienciasBasicas/Topics",
            {
                action: "select",
                area: $("#area-slct").val()
            },
            function (data, status) {
                $("#topic-slct").html(data);
            }
    );
});
$(document).on("change", "#topic-slct", function (event) {
    $("#subtopic-slct").empty();
    $.get("/CienciasBasicas/Subtopics",
            {
                action: "select",
                topic: $("#topic-slct").val()
            },
            function (data, status) {
                $("#subtopic-slct").html(data);
            }
    );
});
/*
 **** ------ END OF SELECTS FOR RESOURCE UPDATING ------ ****
 */