function loadMusics() {
    axios.get('http://localhost:8080/songs')
        .then(res => {
            const songs = res.data;
            console.log(songs);
            var tableText="<style type=\"text/css\">\n" +
                "    .tg  {border-collapse:collapse;border-spacing:0;}\n" +
                "    .tg td{border-color:black;border-style:dashed;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n" +
                "        overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
                "    .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n" +
                "        font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
                "    .tg .thh{background-color:#1db954;border-color:#ffffff;color:#191414;font-family:Impact, Charcoal, sans-serif !important;\n" +
                "        font-size:18px;text-align:left;vertical-align:top}\n" +
                "    .tg .tdd{background-color:#1db954;border-color:#ffffff;color:#191414;font-size:16px;text-align:left;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\"> <thead>\n" +
                "    <tr>\n" +
                "        <th class=\"thh\"></th>\n" +
                "        <th class=\"thh\">Artist</th>\n" +
                "        <th class=\"thh\">Song</th>\n" +
                "        <th class=\"thh\">Album</th>\n" +
                "        <th class=\"thh\">Length</th>\n" +
                "    </tr>\n" +
                "    </thead>";
            var song;
            for (song of songs){
                console.log(song);
                tableText+="<tr><td class=\"tdd\"><input type=\"checkbox\", multiple=\"true\", min=\"2\", id=\"checkbox\"></th></td><td class=\"tdd\">"+song.artist+"</td><td class=\"tdd\">"+song.name+"</td><td class=\"tdd\">"+song.album+"</td><td class=\"tdd\">"+song.length+"</td></tr>"
            }
            tableText+="</table>"
            console.log(tableText);
            document.getElementById("song-container").innerHTML=tableText
            document.getElementById("report-message").innerHTML = "Success"
        })
}

function loadPlaylists() {
    axios.get('http://localhost:8080/playlists')
        .then(res => {
            const playlist = res.data;
            var tableText="<style type=\"text/css\">\n" +
                "    .tg  {border-collapse:collapse;border-spacing:0;}\n" +
                "    .tg td{border-color:black;border-style:dashed;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n" +
                "        overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
                "    .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n" +
                "        font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
                "    .tg .thh{background-color:#1db954;border-color:#ffffff;color:#191414;font-family:Impact, Charcoal, sans-serif !important;\n" +
                "        font-size:18px;text-align:left;vertical-align:top}\n" +
                "    .tg .tdd{background-color:#1db954;border-color:#ffffff;color:#191414;font-size:16px;text-align:left;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\"> <thead>\n" +
                "    <tr>\n" +
                "        <th class=\"thh\">Name</th>\n" +
                "        <th class=\"thh\">Song Count</th>\n" +
                "        <th class=\"thh\">Length (Sec)</th>\n" +
                "    </tr>\n" +
                "    </thead>";
            var pl;
            for (pl of playlist){
                tableText+="<tr><td class=\"tdd\">"+pl.name+"</td><td class=\"tdd\">"+pl.songCount+"</td><td class=\"tdd\">"+pl.plLength+"</td></tr>";
            }
            tableText+="</table>";
            document.getElementById("playlist-container").innerHTML=tableText;
            document.getElementById("report-message").innerHTML = "Success"
        })

}

function searchButtonClicked() {
    const searchInput = document.getElementById("search-input").value;
    axios.get(`http://localhost:8080/songs?search=${searchInput}`)
        .then(res => {
            const songs = res.data;
            console.log(songs);
    })
        .then(res => {
            const songs = res.data;
            reloadTable(songs);
        })
        .catch(error => {
            console.log(error);
            reportMessage();
        });
    document.getElementById("report-message").innerHTML = "Success"
}



function reportMessage() {
    document.getElementById("report-message").innerHTML = "Error"
}

function createButtonClicked() {
    const input = document.getElementById("playlist-input").value;
    const songs = getSelectedSongs();
    const playlist = {
        name: input,
        songs: songs
    };
    axios.post('http://localhost:8080/playlists', playlist)
        .then(res => {
            console.log(res);
            console.log(res.data);
        })
        .catch(error => {
            console.log(error);
            reportMessage();
        });
}

function getSelectedSongs() {
    const checkboxes = document.getElementsByName("checkbox");
    const songs = [];
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            songs.push(checkboxes[i].value);
        }
    }
    return songs;
}


function reloadTable(songs){
    var tableText="<style type=\"text/css\">\n" +
        "    .tg  {border-collapse:collapse;border-spacing:0;}\n" +
        "    .tg td{border-color:black;border-style:dashed;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n" +
        "        overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
        "    .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n" +
        "        font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
        "    .tg .thh{background-color:#1db954;border-color:#ffffff;color:#191414;font-family:Impact, Charcoal, sans-serif !important;\n" +
        "        font-size:18px;text-align:left;vertical-align:top}\n" +
        "    .tg .tdd{background-color:#1db954;border-color:#ffffff;color:#191414;font-size:16px;text-align:left;vertical-align:top}\n" +
        "</style>\n" +
        "<table class=\"tg\"> <thead>\n" +
        "    <tr>\n" +
        "        <th class=\"thh\"></th>\n" +
        "        <th class=\"thh\">Artist</th>\n" +
        "        <th class=\"thh\">Song</th>\n" +
        "        <th class=\"thh\">Album</th>\n" +
        "        <th class=\"thh\">Length</th>\n" +
        "    </tr>\n" +
        "    </thead>";
    var song;
    for (song of songs){
        tableText+="<tr><td class=\"tdd\"><input type=\"checkbox\"></th></td><td class=\"tdd\">"+song.artist+"</td><td class=\"tdd\">"+song.name+"</td><td class=\"tdd\">"+song.album+"</td><td class=\"tdd\">"+song.length+"</td></tr>"
    }
    tableText+="</table>"
    console.log(tableText);
    document.getElementById("song_container").innerHTML=tableText
}
