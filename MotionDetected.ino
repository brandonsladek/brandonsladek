const int ledPin = 13;
const int rgbPin1 = 11;
const int rgbPin2 = 10;
const int rgbPin3 = 9;
const int yellowPin1 = 6;
const int yellowPin2 = 3;
const int inputPin = 2;
int counter = 0;

void setup() {
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
  pinMode(rgbPin1, OUTPUT);
  pinMode(rgbPin2, OUTPUT);
  pinMode(rgbPin3, OUTPUT);
  pinMode(yellowPin1, OUTPUT);
  pinMode(yellowPin2, OUTPUT);
  pinMode(inputPin, INPUT);
}

void loop() {
  int val = digitalRead(inputPin);
  
  if(val == HIGH) {
    if(counter < 100) {
      digitalWrite(rgbPin3, HIGH);
      digitalWrite(ledPin, LOW);
      digitalWrite(yellowPin1, LOW);
      digitalWrite(yellowPin2, LOW);
      Serial.println("Motion detected...");
    }
    else if(counter > 100 && counter < 200) {
      digitalWrite(rgbPin3, LOW);
      digitalWrite(rgbPin2, HIGH);
      digitalWrite(ledPin, LOW);
      digitalWrite(yellowPin1, LOW);
      digitalWrite(yellowPin2, LOW);
      Serial.println("Motion detected...");
    }
    else if(counter > 200) {
      digitalWrite(rgbPin3, LOW);
      digitalWrite(rgbPin2, LOW);
      digitalWrite(rgbPin1, HIGH);
      digitalWrite(ledPin, LOW);
      digitalWrite(yellowPin1, LOW);
      digitalWrite(yellowPin2, LOW);
      Serial.println("Motion detected...");
    }
    counter++;
}
  
  else {
      digitalWrite(rgbPin1, LOW);
      digitalWrite(rgbPin2, LOW);
      digitalWrite(rgbPin3, LOW);
      digitalWrite(ledPin, HIGH);
      digitalWrite(yellowPin1, HIGH);
      digitalWrite(yellowPin2, HIGH);
      Serial.println("------------------");
    }
    
  delay(75);
}
