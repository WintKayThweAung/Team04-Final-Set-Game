function newGame(){
    console.log("New Game");
     $("#saveBtn").on("click", function () {
        console.log("This is new game.");
        $.get("newgame", {
            description: $("#description").val()

        }).done(function () {
            
            $("#description").val("");

        }).fail(function () {

        });
         $.get("api/card/go").done(function () {

        }).fail(function () {
        

        });
    });
    $("#sendBtn").on("click", function () {
        console.log("This is new game.");
        $.get("api/card/go").done(function () {

        }).fail(function () {
        

        });
         
    });
    }

function allGameSelect(gameid)
{
    alert("This is li click. ID is : " + gameid);

    $("#allgamelist").on("click", "a[data-game]", function () {
        console.log("Please-----------");
        //gameid = $(this).attr("id");
        console.log("GameId" + " " + gameid);
        $.get("api/card/" + gameid).done(function () {

        }).fail(function () {

            console.log("Not found!");
        });

    });
}


console.log("here all gamelist function outside");
function allGameList()
{
    var allgameTemplate = Handlebars.compile($("#allgameTemplate").html());

    console.log("This is entry point.");
    $.get("api/card/all").done(function (result) {
        console.log(JSON.stringify(result));
        var allgame = result.Game;
        console.log(JSON.stringify(allgame));
        for (var i in allgame) {
            $("#allgamelist").append(allgameTemplate({
                gameid: allgame[i].GameId,
                description: allgame[i].Description
            }
            ));
        }


    }).fail(function () {
        console.log("No data");
    });

}

 