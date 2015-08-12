var source;
var IP = "localhost";
var PORT = "8080";
$(document).ready(function () {

    var cardTemplate = Handlebars.compile($("#cardTemplate").html());
    var newcardTemplate = Handlebars.compile($("#newcardTemplate").html());
    source = new EventSource("api/card/result");
    source.onmessage = function (event) {
        console.log("Event : " + JSON.stringify(event.data));
        var temp = JSON.parse(event.data);
        var cards = temp.Cards;
        var tempCard1;
        var tempCard2;
        var tempCard3;
        
          $.getJSON("http://"+IP+":"+PORT+"/SetGame/ChooseCardServlet")
            .done(function (result) {
                tempCard1 = result.cardno1session;
                tempCard2 = result.cardno2session;
                tempCard3 = result.cardno3session;
                console.log("FROM JSON : "+tempCard1+","+tempCard2+","+tempCard3);
                
                console.log(" card no 1 2 3 : " + tempCard1 + " " + tempCard2 + " " + tempCard3);
       

        for (var i in cards)
        {
            if (i === "0")
            {
                var cardElement = newcardTemplate({newid: tempCard1, newposition: cards[i]["CardUrl"]});
                $("#" + tempCard1).replaceWith($(cardElement));
                console.log("Replace Card1: " + tempCard1);
            }
            else if (i === "1")
            {
                var cardElement = newcardTemplate({newid: tempCard2, newposition: cards[i]["CardUrl"]});
                $("#" + tempCard2).replaceWith($(cardElement));
                console.log("Replace Card2: " + tempCard2);
            }
            else if (i === "2")
            {
                var cardElement = newcardTemplate({newid: tempCard3, newposition: cards[i]["CardUrl"]});
                $("#" + tempCard3).replaceWith($(cardElement));
                console.log("Replace Card3: " + tempCard3);
            }

            else if (i === "3")
            {
                var cardElement = cardTemplate({position: cards[3]["CardUrl"]});
                $("#correct_img").append($(cardElement));
            }

            else if (i === "4")
            {
                var cardElement = cardTemplate({position: cards[4]["CardUrl"]});
                $("#correct_img").append($(cardElement));
                console.log("Show correct card2 " + cards[4]["CardUrl"]);
            }
            else if (i === "5")
            {
                var cardElement = cardTemplate({position: cards[5]["CardUrl"]});
                $("#correct_img").append($(cardElement));
                console.log("Show correct card3");
            }
        }

            }).fail(function () {
        console.log("Not found!");
    });

        

    };
});


