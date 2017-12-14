CREATE TABLE public.player
(
  player_id SERIAL PRIMARY KEY NOT NULL,
  username VARCHAR(35) NOT NULL,
  password VARCHAR(35) NOT NULL
)