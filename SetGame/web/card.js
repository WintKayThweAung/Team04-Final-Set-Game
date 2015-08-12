$(document).ready(function () {
    var cardTemplate = Handlebars.compile($("#cardTemplate").html());
    $.getJSON("api/card/twelvecard")
            .done(function (result) {
                var id = result.GameId;
                console.log(id);
                $("#gameid").val(id);

                var count1 = 0;
                for (var a = 0; a < result.cards.length; a++)
                {
                    var cardElement = cardTemplate({position: result.cards[a].CardUrl});
                    $("#" + a).append($(cardElement));
                }
            }).fail(function () {
        console.log("Not found!");
    });
});

$(function () {
    $("#Btnsubmit").on("click", function () {
        console.log("From JS");
        if ($("#card1").val() !== null || $("#card2").val() !== null || $("#card3").val() !== null)
        {
            cardno1 = $("#card1").val();
            cardno2 = $("#card2").val();
            cardno3 = $("#card3").val();
            alert("already substitude");
        }
        $.get("validateCard", {
            gameid: $("#gameid").val(),
            card1: $("#card1").val(),
            card2: $("#card2").val(),
            card3: $("#card3").val()
        }).done(function () {
            $("#card1").val("");
            $("#card2").val("");
            $("#card3").val("");
        });
    });
});

