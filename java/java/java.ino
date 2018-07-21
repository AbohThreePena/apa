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
//  kirimData2();

  int input; // pc ke arduino
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

void kirimData(){ // arduino ke komputer
  int buttonState = digitalRead(tombol_karcis);
  if (buttonState == HIGH) {
    Serial.println(buttonState);
    digitalWrite(led_merah, HIGH);
    digitalWrite(led_hijau, HIGH);
    delay(1000);
    digitalWrite(led_merah, LOW);
    digitalWrite(led_hijau, LOW);
  }
}
void kirimData2() {
  int buttonState2 = digitalRead(tombol_karcis);
  if (buttonState2 == LOW) {
    Serial.println(buttonState2);
    digitalWrite(led_merah, LOW);
    digitalWrite(led_hijau, LOW);
    }    
}


