$(function () {
    $(".updateCom").on("click", function () {

        let a = $(this).parents(".component-row").first();
        let id = a.find(".id").first().text();
        let name = a.find(".name").first().text();
        let need = a.find(".need").first().text() === "да";
        let count = a.find(".count").first().text();
        //              console.log(id, name, need, count);
        document.getElementById('idInputForm').value = id;
        document.getElementById('idNameForm').value = name;
        document.getElementById('idNeedForm').value = need;
        document.getElementById('idCountForm').value = count;
        //     $.post("/updates", {id, name, need, count});
        return false;

    });

});

$(function () {
    $(".updateButton").on("click", function () {

        let id = document.getElementById("idInputForm").value;
        let name = document.getElementById("idNameForm").value;
        let need = document.getElementById("idNeedForm").value;
        let count = document.getElementById("idCountForm").value;
        console.log(id, name, need, count);

        $.post("/updates", {id, name, need, count});

        window.location.href = "/parts";
        window.location.reload();
        return false;


    });

});