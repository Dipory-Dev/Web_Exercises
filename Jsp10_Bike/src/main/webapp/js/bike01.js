$(function() {
    getJson();
})

function getJson() {
    $.getJSON( "json/bike.json", function(data){
        $.each(data, function(key, val){
            if (key == "DESCRIPTION"){
                $("thead").append(
                    "<tr>"+
                        "<th>NO.</th>" +
                        "<th>" + val.ADDR_GU + "</th>" +
                        "<th>" + val.CONTENT_ID + "</th>" +
                        "<th>" + val.CONTENT_NM + "</th>" +
                        "<th>" + val.NEW_ADDR + "</th>" +
                        "<th>" + val.CRADLE_COUNT + "</th>" +
                        "<th>" + val.LONGITUDE + "</th>" +
                        "<th>" + val.LATITUDE + "</th>" +
                        "<th>Delete</th>"
                    +"</tr>"
                );
            } else {
                for(let i = 0; i < val.length; i++ ){
                    // console.log(val.length);
                    $("tbody").append(
                        "<tr>" +
                            "<td>" + (i + 1) + "</td>" +
                            "<td>" + val[i].addr_gu + "</td>" +
                            "<td>" + val[i].content_id + "</td>" +
                            "<td>" + val[i].content_nm + "</td>" +
                            "<td>" + val[i].new_addr + "</td>" +
                            "<td>" + val[i].cradle_count + "</td>" +
                            "<td>" + val[i].longitude + "</td>" +
                            "<td>" + val[i].latitude + "</td>" +
                            "<td><input type='button' value='Delete' onclick='chk(" + val[i].content_id + ")'></td>" +
                            "<input type='hidden' name='bike' value='" 
                            + val[i].addr_gu + "/" + val[i].content_id + "/" + val[i].content_nm
                            + "/" + val[i].new_addr + "/" + val[i].cradle_count + "/" + val[i].longitude
                            + "/" + val[i].latitude + "'/>"
                        +"</tr>"
                    );
                }
            }
        });
    } );
}

function chk(i) {
    if (window.confirm("Wanna Delete?")) {
        location.href='bike?command=del_db&cid=' + i;
    }

}