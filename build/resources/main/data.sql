INSERT INTO T_ARTIST (name) VALUES ('Nirvana');
INSERT INTO T_ARTIST (name) VALUES ('Metallica');
INSERT INTO T_ARTIST (name) VALUES ('Mac Miller');
INSERT INTO T_ARTIST (name) VALUES ('Cem Karaca');

INSERT INTO T_ALBUM (name, ARTIST_ID) VALUES ('Nevermind', 1);
INSERT INTO T_ALBUM (name, ARTIST_ID) VALUES ('Hardwired', 2);
INSERT INTO T_ALBUM (name, ARTIST_ID) VALUES ('Swimming', 3);
INSERT INTO T_ALBUM (name, ARTIST_ID) VALUES ('Merhaba Gençler', 4);

INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Heart-Shaped Box', 1, 1, '3.23');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Something in the way', 1,1 , '3.36');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Polly', 1, 1, '4.14');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Smells Like Teen Spirit', 1, 1, '3.43');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Enter Sandman', 2, 2,'3.43');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Kool Aid', 3, 3,  '3.26');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Ladders', 3, 3, '3.26');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('2009', 3, 3, '3.26');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Oh Be', 4, 4, '3.26');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Namus Belası', 4, 4, '3.26');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Ay Karanlık', 4, 4, '3.26');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Sevda Kuşun Kanadında', 4, 4, '3.26');


INSERT INTO T_PLAYLIST (name) VALUES ('Rock Classics');
INSERT INTO T_PLAYLIST (name) VALUES ('Masterpiece');
INSERT INTO T_PLAYLIST (name) VALUES ('Anadolu Rock');

INSERT INTO REL_PLAYLIST_SONG (PL_ID, SONG_ID) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5);
INSERT INTO REL_PLAYLIST_SONG (PL_ID, SONG_ID) VALUES (2, 6), (2, 7), (2, 8);
INSERT INTO REL_PLAYLIST_SONG (PL_ID, SONG_ID) VALUES (3, 9), (3, 10), (3, 11), (3, 12);

INSERT INTO REL_PLAYLIST (PARENT_PL_ID, CHILD_PL_ID) VALUES (1, 2), (1, 3);
