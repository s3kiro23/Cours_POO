from unittest import result
import cv2
import mediapipe as mp

def main():
    mp_drawing = mp.solutions.drawing_utils
    mp_hands = mp.solutions.hands

    cap = cv2.VideoCapture(0)
    with mp_hands.Hands(min_detection_confidence=0.5, min_tracking_confidence=0.5) as hands:
        while cap.isOpened():
            data, image = cap.read()
            image = cv2.flip(cv2.cvtColor(image, cv2.COLOR_BGR2RGB), 1)
            results = hands.process(image)
            image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
            if results.multi_hand_landmarks:
                for num, hand_landmarks in enumerate(results.multi_hand_landmarks):
                    mp_drawing.draw_landmarks(image, hand_landmarks, mp_hands.HAND_CONNECTIONS)
                    if num == 1:
                        print(results.multi_hand_landmarks[1].landmark[mp_hands.HandLandmark.MIDDLE_FINGER_TIP])
            
            cv2.imshow('Handtracker', image)
            k = cv2.waitKey(33)
            if k == 27:
                break

        cap.release()
        cv2.destroyAllWindows()


if __name__ == "__main__":
    main()