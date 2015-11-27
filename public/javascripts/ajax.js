(function () {
  'use strict';
  
  window.openData = {
    getOpenData: function () {
      $.ajax({
        type: 'GET',
        url: '/rest'
      }).done(function (res) {
        console.log("",res);
        $('.main').append(res);
      });
    }
  };
})();
