var IP = "localhost";
var PORT = "8080";
var currentId;
var temp = ["#"];

// Sign In & Sign Up Start
$(document).on("pagecreate", "#signinup", function () {
    $("#signinBtn").on("click", function () {
        $.mobile.navigate("#login", {transition: "slide"});

    });

    $("#signupBtn").on("click", function () {
        $.mobile.navigate("#createnew", {transition: "slide"});
    });

});
// Sign In & Sign Up End

// Login Start   
var url = "http://" + IP + ":" + PORT + "/SetGame/";
$(document).on("pagecreate", "#login", function () {
    $("#loginBtn").on("click", function () {
        $("#message").text("");
        name = $("#accName").val();
        password = $("#password").val();
        console.log("Button event active");
        $.get(url + "api/player/" + name + "/" + password)
                .done(function (result)
                {
                    alert("Correct");
                    $.mobile.navigate("#gamelist", {transition: "slide"});

                }).fail(function () {

            $("#message").text("UserName or Password is incorrect.");
            alert("Wrong");
        });
    });

});

// Login End


// GameList Start   
$(document).on("pagecreate", "#gamelist", function () {

    console.log("Page Create For Game List");

    $("#game_list").on("click", "li[data-gameid]", function () {
        console.log("Current ID : " + $(this).attr("data-gameid"));
        currentId = $(this).attr("data-gameid");
        $("#gameIdShow").append("<b>Game ID : " + currentId + "</b>");
        $.mobile.navigate("#game", {transition: "slide"});
    });
});


$(document).on("pagecontainershow", function (_, $ui) {

    function loadGameList($ul) {

        var cardItemTemplate = Handlebars.compile($("#allgameTemplate").html());
        $.getJSON("http://" + IP + ":" + PORT + "/SetGame/api/card/all/")
                .done(function (result) {
                    console.log("Grand");
                    console.log(JSON.stringify(result));
                    $ul.empty();
                    var game = result.Game; //array
                    for (var i in game) {
                        $ul.append(cardItemTemplate({
                            GameId: game[i].GameId,
                            Description: game[i].Description
                        }));
                    }

                    $ul.listview("refresh");
                    $.mobile.loading("hide");
                }).fail(function (result)
        {
            console.log("Error");
        });

    }
    ;
    switch ($ui.toPage.attr("id")) {
        case "gamelist":
            loadGameList($("#game_list"));
            $.mobile.loading("show");
            break;
        case "login":
            console.log("hi");
        default:
    }

});

// GameList End


// Play Game Start

function ClickMe(myid)
{
    temp.push(myid);
    alert(temp);
}
$(document).on("pagecreate", "#game", function () {
    console.log("Page Create For Game");
    $("#gameSubmit").on("click", function () {
        console.log("Click Accept");
        console.log("Current Id is : " + currentId);

        cardno1 = temp[1];
        cardno2 = temp[2];
        cardno3 = temp[3];

        alert(cardno1 + " , " + cardno2 + " , " + cardno3);

        $.get("http://" + IP + ":" + PORT + "/SetGame/validateCard", {
            gameid: currentId,
            card1: temp[1],
            card2: temp[2],
            card3: temp[3]
        }).done(function () {
            temp = ["#"];
            console.log("Arrive");
            alert("Finish to send");
        });


    });
    $("#clearBtn").on("click", function () {
        temp = ["#"];
        console.log("All clear!!!");
    });

});

// Play Game End

// Sign Up Start

$(document).on("pagecreate", "#createnew", function () {
    console.log("Page Create For Sign Up");
    $("#accsignUpBtn").on("click", function () {
        console.log("Click Accept");

        name = $("#accNameForSignUp").val();
        password = $("#passwordForSignUp").val();
        confirmpassword = $("#confirmpassword").val();

        if (password === confirmpassword)
        {
            $.get(url + "api/player/createAccount?playerName=" + name + "&password=" + password)
                    .done(function () {
                        console.log("Arrive");
                        alert("Finish Account create");
                        $.mobile.navigate("#gamelist", {transition: "slide"});

                    }).fail(function () {
                //alert("Input Field is invalid.");
                if (name !== "" || password !== "" || confirmpassword !== "") {
                    $("#signupmessage").text("Input Field is invalid.");
                }
            });

        }
        else if (password !== confirmpassword)
        {
            //alert("Password and ConfirmedPassword is must be same.");
            $("#signupmessage").text("Password and ConfirmedPassword must be same.");

        }

    });


});
// Sign Up End