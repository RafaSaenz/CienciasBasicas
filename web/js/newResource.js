/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).on('change', '#fileType', function (event) {
    var optionSelected = $(event.target).find("option:selected", this);
    console.log(this.value);
    switch (this.value) {
        case 'vid':
            $("#file2")[0].type = 'text';
            $("#file2")[0].name = 'video';
            $("#file2lbl").html("Link:");
            break;
        case 'doc':
            $("#file2")[0].type = 'file';
            $("#file2lbl").html("Archivo (Max 40MB):");
            $("#file2")[0].name = 'document';
            break;
        case 'img':
            $("#file2")[0].name = 'image';
            $("#file2")[0].type = 'file';
            $("#file2lbl").html("Archivo (Max 40MB):");
            break;
    }
    $("#file2").show();
});
//Retrieve topics for the select box
$(document).on("change", "#area", function (event) {
    $.get("/CienciasBasicas/Topics",
            {
                action: "select",
                area: $("#area").val()
            },
            function (data, status) {
                $("#topic").html(data);
            }
    );
});
//Retrieve subtopics for the select box
$(document).on("change", "#topic", function (event) {
    $.get("/CienciasBasicas/Subtopics",
            {
                action: "select",
                topic: $("#topic").val()
            },
            function (data, status) {
                $("#subtopic").html(data);
            }
    );
});
function checkFile() {
    var fileElement = document.getElementById("file");
    var fileExtension = "";
    if (fileElement.value.lastIndexOf(".") > 0) {
        fileExtension = fileElement.value.substring(fileElement.value.lastIndexOf(".") + 1, fileElement.value.length);
    }
    if (fileExtension.toLowerCase() === "jpg" || fileExtension.toLowerCase() === "png") {
        return true;
    } else {
        alert("Extensiones de archivo válidas: .jpg .png");
        return false;
    }
}