const rolls = [
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "Oops this isn't the right prompt",
]

const btn = document.querySelector("#changeText");
btn.addEventListener("click", function () {
    let txt
    currentText = document.querySelector("#home-quotes").innerHTML
    do {
        txt = rolls[Math.round(Math.random() * (rolls.length - 1))]
    } while (txt === currentText)
    document.querySelector("#home-quotes").innerHTML = txt
});
