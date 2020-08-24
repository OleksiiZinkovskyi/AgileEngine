CREATE TABLE IF NOT EXISTS image (
  id INT PRIMARY KEY,
  author VARCHAR(250),
  camera VARCHAR(250),
  tags VARCHAR(250),
  cropped_picture VARCHAR(250),
  full_picture VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS token (
  id INT AUTO_INCREMENT PRIMARY KEY,
  issued TIMESTAMP,
  expired BOOLEAN,
  token VARCHAR(250)
);