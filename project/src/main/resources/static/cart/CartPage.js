//load function
window.onload = function () {
    seeCartItems();
  };

  const seeCartItems = async () => {
    const resp = await fetch("/getCartItems")
    const data = await resp.json()

    console.log(data)
    createCartItems(data)
    return data
  }

  function createCartItems(bookJson){

    for(let i = 0; i < bookJson.length; i++){

        const newBookName = document.createTextNode(bookJson[i].bookName);
        const newBookAuthor = document.createTextNode(bookJson[i].bookAuthor);
        const newBookGenre = document.createTextNode(bookJson[i].bookGenre);
        const newBookPrice = document.createTextNode("$" + bookJson[i].bookPrice);
        const newBookQuantity = document.createTextNode(bookJson[i].quantity);
        const newBookImage = bookJson[i].bookPicture;

        const newColRounded = document.createElement("div");
        newColRounded.className = "card rounded-3 mb-4";

        const newCardBody = document.createElement("div");
        newCardBody.className = "card-body p-4";

        const rowDFlex = document.createElement("div");
        rowDFlex.className = "row d-flex justify-content-between align-items-center";

        const imgCol = document.createElement("div");
        imgCol.className = "col-md-2 col-lg-2 col-xl-2";

        const imageDiv = document.createElement("img");
        imageDiv.setAttribute("src", "data:image/png;base64," + newBookImage);
        imageDiv.className = "img-fluid rounded-3";

        const leftDiv = document.createElement("div");
        leftDiv.className = "col-md-3 col-lg-3 col-xl-3";

        const namePara = document.createElement("p"); //Editing goes here
        namePara.className = "lead fw-normal mb-2";
        namePara.appendChild(newBookName);

        const authorPara = document.createElement("p"); //Editing goes here
        authorPara.className = "text-muted";
        authorPara.appendChild(newBookAuthor);

        const middleDiv = document.createElement("div");
        middleDiv.className = "col-md-3 col-lg-3 col-xl-2 d-flex";

        const quantityDiv = document.createElement("div"); //Edititon goes here
        quantityDiv.className = "form-control form-control-sm";
        quantityDiv.appendChild(newBookQuantity);

        const rightDiv = document.createElement("div");
        rightDiv.className = "col-md-3 col-lg-2 col-xl-2 offset-lg-1";

        const priceDiv = document.createElement("h5"); //Editing goes here
        priceDiv.className = "mb-0";
        priceDiv.appendChild(newBookPrice);

        imgCol.appendChild(imageDiv);
        leftDiv.appendChild(namePara);
        leftDiv.appendChild(authorPara);
        middleDiv.appendChild(quantityDiv);
        rightDiv.appendChild(priceDiv);

        rowDFlex.appendChild(imgCol);
        rowDFlex.appendChild(leftDiv);
        rowDFlex.appendChild(middleDiv);
        rowDFlex.appendChild(rightDiv);

        newCardBody.appendChild(rowDFlex);
        newColRounded.appendChild(newCardBody);

        const frontPageDiv = document.getElementById("fullPage");
        frontPageDiv.appendChild(newColRounded);
    }
  }