//load function
window.onload = function () {
    seeAllBooks();
  };
  
  function seeAllBooks() {
    //fetch books from database using api
    fetch("/books")
      .then(function (response) {
        const bookListResp = response.json();
        return bookListResp;
      })
      .then(
        //send function to print out books on html page
        function (bookList) {
          createBookElement(bookList);
        }
      );
  }

  /**
   * 
   * @param {*} bookJson Json holding data of books
   */
  function createBookElement(bookJson) {
    for (let i = 0; i < bookJson.length; i++) {
      // const numberOfItemsInRow = 3;
  
      // //data from individual books
      const newBookName = document.createTextNode(bookJson[i].bookName);
      const newBookAuthor = document.createTextNode(bookJson[i].bookAuthor);
      const newBookGenre = document.createTextNode(bookJson[i].bookGenre);
      const newBookPrice = document.createTextNode("$" + bookJson[i].bookPrice);
      const newBookImage = bookJson[i].bookPicture;
  
      const newBookNameP = document.createElement("h5");
      const newBookAuthorP = document.createElement("p");
      const newBookGenreP = document.createElement("p");
      const newBookPriceP = document.createElement("p");
  
      newBookNameP.appendChild(newBookName);
      newBookAuthorP.appendChild(newBookAuthor);
      newBookGenreP.appendChild(newBookGenre);
      newBookPriceP.appendChild(newBookPrice);
  

      //make new opening elements
      const newCol = document.createElement("div");
      newCol.className = "col";
  
      const newCard = document.createElement("div");
      newCard.className = "card mb-3";
      newCard.setAttribute("style", "max-width: 540px;");
  
      //make elements for inner row and cols
      //<div class="row g-0">
      const newInnerRow = document.createElement("div");
      newInnerRow.className = "row g-0";
  
      //<div class="col-md-4">
      const newInnerCol4 = document.createElement("div");
      newInnerCol4.className = "col-md-4";
  
      //<div class="col-md-8">
      const newInnerCol8 = document.createElement("div");
      newInnerCol8.className = "col-md-8";
  
      //make elements for img
      const newImg = document.createElement("img");
      newImg.setAttribute("src", "data:image/png;base64," + newBookImage);
      newImg.className = "img-fluid rounded-start bookThumbnail";
  
      //make elements for body
      const newCardBody = document.createElement("div");
      newCardBody.className = "card-body";
  
      //append json data to body
      //make and append the title to the card-body
      const newCardTitle = document.createElement("div");
      newCardTitle.className = "card-title";
      newCardTitle.append(newBookNameP);
      newCardBody.appendChild(newCardTitle);
  
      //make and append the body to the card-body
      newCardBody.appendChild(newBookAuthorP);
      newCardBody.appendChild(newBookGenreP);
      newCardBody.appendChild(newBookPriceP);
  
      //append card-body to innerCol8
      newInnerCol8.appendChild(newCardBody);
  
      //make and append the body to the card-body
      newCardBody.appendChild(newBookAuthorP);
      newCardBody.appendChild(newBookGenreP);
      newCardBody.appendChild(newBookPriceP);
    
      //make button and add element to the card-body
      const newButton = document.createElement("button");
      newButton.className = "btn btn-primary";
      newButton.innerText = "Add to Cart";
      newButton.onclick = function () {
        console.log("BookId:", bookJson[i].bookId);
      };
      newCardBody.appendChild(newButton);

      //append inner row to card
      newCard.appendChild(newInnerRow);
  
      //append img to innerCol4
      newInnerCol4.appendChild(newImg);
  
      //append innerCol4 and innerCol8 to innerRow
      newInnerRow.appendChild(newInnerCol4);
      newInnerRow.appendChild(newInnerCol8);
  
      //append new card to new col
      newCol.appendChild(newCard);
  
      //put card onto the main page
      const frontPageDiv = document.getElementById("fullPage");
      frontPageDiv.appendChild(newCol);
  
      //append innerCol4 and innerCol8 to innerRow
      newInnerRow.appendChild(newInnerCol4);
      newInnerRow.appendChild(newInnerCol8);
  
      //append new card to new col
      newCol.appendChild(newCard);
  
      console.log(newCol);
    }
  }
  
  let arrayOfBooks = [];

//   function addToCart(inputBookJson) {
//     arrayOfBooks.push(inputBookJson);
  
//     console.log("Inside cart. Added", inputBookJson.bookName);
//     //console.log(arrayOfBooks);
  
//     //insert data inside element
//     const newListElement = document.createElement("li");
//     newListElement.className = "list-group-item";
//     newListElement.innerText = inputBookJson.bookName;
  
//     //put new list element on main page
//     const frontpagelist = document.getElementById("fullPageCheckout");
//     frontpagelist.appendChild(newListElement);      
  
//       ////////////////////VERSION 3\\\\\\\\\\\\\\\\\\\\\\\\
  
//       //make new opening elements
//       const newCol = document.createElement("div");
//       newCol.className = "col";
  
//       const newCard = document.createElement("div");
//       newCard.className = "card mb-3";
//       newCard.setAttribute("style", "max-width: 540px;");
  
//       //make elements for inner row and cols
//       //<div class="row g-0">
//       const newInnerRow = document.createElement("div");
//       newInnerRow.className = "row g-0";
  
//       //<div class="col-md-4">
//       const newInnerCol4 = document.createElement("div");
//       newInnerCol4.className = "col-md-4";
  
//       //<div class="col-md-8">
//       const newInnerCol8 = document.createElement("div");
//       newInnerCol8.className = "col-md-8";
  
//       //make elements for img
//       const newImg = document.createElement("img");
//       newImg.setAttribute("src", "data:image/png;base64," + newBookImage);
//       newImg.className = "img-fluid rounded-start bookThumbnail";
  
//       //make elements for body
//       const newCardBody = document.createElement("div");
//       newCardBody.className = "card-body";
  
//       //append json data to body
//       //make and append the title to the card-body
//       const newCardTitle = document.createElement("div");
//       newCardTitle.className = "card-title";
//       newCardTitle.append(newBookNameP);
//       newCardBody.appendChild(newCardTitle);
  
//       //make and append the body to the card-body
//       newCardBody.appendChild(newBookAuthorP);
//       newCardBody.appendChild(newBookGenreP);
//       newCardBody.appendChild(newBookPriceP);
  
//       //make button and add element to the card-body
//       const newButton = document.createElement("button");
//       newButton.className = "btn btn-primary";
//       newButton.innerText = "Add to Cart";
//       newButton.onclick = function () {
//         console.log("BookId:", bookJson[i].bookId);
//       };
//       newCardBody.appendChild(newButton);
  
//       //append card-body to innerCol8
//       newInnerCol8.appendChild(newCardBody);
  
//       //append inner row to card
//       newCard.appendChild(newInnerRow);
  
//       //append img to innerCol4
//       newInnerCol4.appendChild(newImg);
  
//       //append innerCol4 and innerCol8 to innerRow
//       newInnerRow.appendChild(newInnerCol4);
//       newInnerRow.appendChild(newInnerCol8);
  
//       //append new card to new col
//       newCol.appendChild(newCard);
  
//       //put card onto the main page
//       const frontPageDiv = document.getElementById("fullPage");
//       frontPageDiv.appendChild(newCol);
  
//       console.log(newCol);
//     }
  
  