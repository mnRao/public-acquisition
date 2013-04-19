<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript">
$(document).ready(function(){

$.getJSON( "json/visits")
.done(function( json ) {
  //console.log( "JSON Data: " + json.count );
  //console.log( "JSON Data: " + json.countTotal );
  $("#footer-counter").html("Vizite: " + json.count + "/"+ json.countTotal);
})
.fail(function( jqxhr, textStatus, error ) {
  var err = textStatus + ', ' + error;
  console.log( "Request Failed: " + err);
});


}); 
</script>

<footer id="footer">
                <div id="footer-main">
    <span>2012. Moldova Republic Of. All rights reserved.
    </span>
    <div id="footer-counter">

    </div>  
    </div>  
</footer><!-- #footer -->

