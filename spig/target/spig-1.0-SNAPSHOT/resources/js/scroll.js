// Hide Header on on scroll down
                    var didScroll;
                    var lastScrollTop = 0;
                    var delta = 5;
                    var navbarHeight = $('header').outerHeight();

                    $(window).scroll(function(event){
                        didScroll = true;
                    });

                    setInterval(function() {
                        if (didScroll) {
                            hasScrolled();
                            didScroll = false;
                        }
                    }, 250);

                    function hasScrolled() {
                        var st = $(this).scrollTop();

                        // Make sure they scroll more than delta
                        if(Math.abs(lastScrollTop - st) <= delta) 
                            return;

                        // If they scrolled down and are past the navbar, add class .nav-up.
                        // This is necessary so you never see what is "behind" the navbar.
                        if (st > lastScrollTop && st > navbarHeight){
                            // Scroll Down
                            $('header').removeClass('nav-down').addClass('nav-up');
                        } else {
                            // Scroll Up
                            if(st + $(window).height() < $(document).height()) {
                                $('header').removeClass('nav-up').addClass('nav-down');
                            }
                        }

                        lastScrollTop = st;
                    }


                    var images = [
                      "resources/img/slide_1.jpg",
                      "resources/img/slide_2.jpg",
                      "resources/img/slide_3.jpg"
                    ];

                    var bdy = document.getElementsByTagName("BODY")[0];

                    var i = 0;
                    setInterval(function() {
                          bdy.style.backgroundImage = "url(" + images[i] + ")";
                          i = i + 1;
                          if (i == images.length) {
                            i =  0;
                          }
                    }, 5000);
