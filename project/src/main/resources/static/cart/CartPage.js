//load function
window.onload = function () {
    seeCartItems();
  };

  const seeCartItems = async () => {
    const resp = await fetch("/getCartItems")
    const data = await resp.json()

    console.log(data)
    return data
  }