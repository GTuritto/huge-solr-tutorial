(function ($) {

AjaxSolr.theme.prototype.result = function (doc, snippet) {
  var output = '<div><h2>' + doc.name + '</h2>';
  output += '<p id="links_' + doc.id + '" class="links"></p>';
  output += '<p>' + snippet + '</p></div>';
  return output;
};

AjaxSolr.theme.prototype.snippet = function (doc) {
  var output = '';
  output += doc.address + (doc.address_extended ? ', ' + doc.address_extended : '') + ', ';
  output += doc.city + ', ' + doc.state + ' ' + doc.zip + '<br/>';
  if (doc.neighborhood)
	  output += '(' + doc.neighborhood + ') ';
  if (doc.rating)
	  output += doc.rating + '/5 ';
  if (doc.price)
	  for (var i = 0; i < doc.price; i++)
		  output += '$';
  if (doc.wifi)
	  output += ' wifi';
  output += '<br/>';
  if (doc.cuisine)
	  output += doc.cuisine + '<br/>';
  output += '<i>' + 'F/M: ' + (doc.female/doc.male).toFixed(2) + ' | Singles: ' + (doc.unmarried*100).toFixed(1) + '% | Income: $' + (doc.income/1000).toFixed(1) +'k</i>';
  return output;
};

AjaxSolr.theme.prototype.tag = function (value, weight, handler) {
  return $('<a href="#" class="tagcloud_item"/>').text(value).addClass('tagcloud_size_' + weight).click(handler);
};

AjaxSolr.theme.prototype.facet_link = function (field, value, handler) {
  return [ field + ':', $('<a href="#"/>').text(value).click(handler) ];
};

AjaxSolr.theme.prototype.no_items_found = function () {
  return 'no items found in current selection';
};

})(jQuery);
