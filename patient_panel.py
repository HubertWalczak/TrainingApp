import streamlit as st
import cv2
import datetime
from peewee import SqliteDatabase
from playhouse.reflection import generate_models
from config import config

db = SqliteDatabase(config['sqlite']['path'])
models = generate_models(db)
globals().update(models)

def patient_panel():
    st.title("PATIENT PANEL 💉")
    query = patient.select(patient.name_surname)
    lista = [i.name_surname for i in query]
    lista.append('+ Add new patient')
    pacjent = st.selectbox(
        'Select patient:',
        lista)

    if pacjent == "+ Add new patient":
        st.header("Complete the patient's data:")
        name = st.text_input('Name:')
        age = st.text_input('Age:')
        data = st.date_input(
            "Choose date:",
            datetime.date.today())
        confirm = st.button('Submit')
        if confirm:
            st.success('Patient added successully!')

    else:
        check_id = patient.select().where(patient.name_surname == pacjent).get()
        col1, col2 = st.columns(2)
        with col1:
            image = cv2.imread("../pictures/anony.jpg")
            image1 = cv2.resize(image, (220, 220))
            image2 = cv2.cvtColor(image1, cv2.COLOR_RGB2BGR)
            st.image(image2)

            st.text(" ")
            st.subheader("PATIENT'S DATA:")
            st.write("*** Name:   ***", (patient.get(patient.name_surname == pacjent).name_surname).split()[0])
            st.write("*** Surname:   ***", (patient.get(patient.name_surname == pacjent).name_surname).split()[1])
            st.write("***Age:   ***", patient.get(patient.id == check_id).age)



        with col2:
            st.header("RESULTS:")
            #st.info('Please, choose one option!')
            measurements = st.radio(
                    "Which measurements you want to display",
                    ('Hand measurements', 'Haptic measurements'))
            
            if measurements == 'Hand measurements':
                hand = st.selectbox(
                    'Select hand:',
                    ('Right hand', 'Left hand'))
                if hand == 'Right hand':
                    st.write("The length of the right hand is eqaul:", hand_width.get((hand_width.patient_id == check_id) & (hand_width.which_hand == 'right')).hand_width)
                    st.write("The spread of the right hand is equal:", finger_spread.get((finger_spread.patient_id == check_id) & (finger_spread.which_hand == 'right')).spread)
                    st.write("The wrist flection of the right hand is equal:", wrist_flection.get((wrist_flection.patient_id == check_id) & (wrist_flection.which_hand == 'right')).wrist_flection)
                if hand == 'Left hand':
                    st.write("The length of the right hand is eqaul:", hand_width.get((hand_width.patient_id == check_id) & (hand_width.which_hand == 'left')).hand_width)
                #st.write("The wrist flection of the right hand is equal:", wrist_flection.get(wrist_flection.patient_id == check_id).wrist_flection)
                """
                chart_data = random.sample(range(3, 15), 5)
                st.bar_chart(chart_data)
            elif haptyczne:
                st.text("Max length:")
                chart_data1 = pd.DataFrame(np.random.randn(50, 1))
                st.line_chart(chart_data1)
                """
    return
