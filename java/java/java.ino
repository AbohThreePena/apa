int const led_hijau = 3;
int const led_merah = 4;
int const tombol_karcis = 5;

void setup() {
   Serial.begin(9600);
   pinMode(led_hijau, OUTPUT);
   pinMode(led_merah, OUTPUT);
   pinMode(tombol_karcis, INPUT);
   digitalWrite(led_merah, LOW);
   digitalWrite(led_hijau, LOW);
}
//
void loop() { 
  kirimData();

  int input;
  if (Serial.available() > 0){
          input = Serial.parseInt();
          if (input == 1){
            digitalWrite(led_hijau, HIGH);
          }
          if (input == 2){
            digitalWrite(led_merah, HIGH);
          }
          if (input == 3){
            digitalWrite(led_hijau, LOW);
            digitalWrite(led_merah, LOW);
          }
  }
}

void kirimData(){
  int buttonState = digitalRead(tombol_karcis);
  if (buttonState == HIGH) {
//    Serial.println(buttonState);
    digitalWrite(led_merah, HIGH);
    digitalWrite(led_hijau, HIGH);
  }
}

