from tkinter import *
from datetime import date

# Initialize the count variable
brenda = 0

def click():
    global brenda
    brenda += 1
    label.config(text="Né Brenda?: " + str(brenda))

def end_day():
    global brenda
    # Store the count with today's date in the ranking data
    ranking_entry = (date.today().strftime("%d/%m/%Y"), brenda)
    save_ranking_to_file(ranking_entry)
    
    # Clear the window
    for widget in window.winfo_children():
        widget.destroy()
    
    # Create frames for layout
    left_frame = Frame(window)
    left_frame.pack(side=LEFT, expand=True, fill=BOTH, padx=10, pady=10)
    right_frame = Frame(window)
    right_frame.pack(side=RIGHT, expand=True, fill=BOTH, padx=10, pady=10)

    # Add labels to the left frame
    end_label = Label(left_frame, text="Acabou a aula de AED2", font=("Comic Sans", 24))
    end_label.pack(expand=True, pady=20)
    total_label = Label(left_frame, text="Total: " + str(brenda), font=("Comic Sans", 24))
    total_label.pack(expand=True, pady=20)

    # Add ranking to the right frame with a canvas and scrollbar
    ranking_canvas = Canvas(right_frame)
    scrollbar = Scrollbar(right_frame, orient="vertical", command=ranking_canvas.yview)
    scrollable_frame = Frame(ranking_canvas)

    scrollable_frame.bind(
        "<Configure>",
        lambda e: ranking_canvas.configure(
            scrollregion=ranking_canvas.bbox("all")
        )
    )

    ranking_canvas.create_window((0, 0), window=scrollable_frame, anchor="nw")
    ranking_canvas.configure(yscrollcommand=scrollbar.set)

    ranking_canvas.pack(side="left", fill="both", expand=True)
    scrollbar.pack(side="right", fill="y")

    try:
        ranking_label = Label(scrollable_frame, text="Ranking:", font=("Comic Sans", 24))
        ranking_label.pack(expand=True, pady=20)
        
        ranking_data = []
        with open("RANKING.txt", "r") as file:
            for line in file:
                date_str, count_str = line.strip().split(" - Total brenda++: ")
                count = int(count_str)
                ranking_data.append((date_str, count))
        
        # Sort the ranking data by count in descending order
        ranking_data.sort(key=lambda x: x[1], reverse=True)
        
        for date_str, count in ranking_data:
            ranking_entry = Label(scrollable_frame, text=f"{date_str} - Total brenda++: {count}", font=("Comic Sans", 18))
            ranking_entry.pack()
    except FileNotFoundError:
        no_data_label = Label(scrollable_frame, text="Nenhum dado disponível", font=("Comic Sans", 18))
        no_data_label.pack()
    
    # Add button to start another class at the bottom of the left frame
    start_button = Button(left_frame, text="Começar outra aula", command=start_new_class, font=("Comic Sans", 24), width=15, height=3)
    start_button.pack(expand=True, pady=10)

def save_ranking_to_file(entry):
    with open("RANKING.txt", "a") as file:
        file.write(f"{entry[0]} - Total brenda++: {entry[1]}\n")

def start_new_class():
    global brenda
    brenda = 0
    # Clear the window
    for widget in window.winfo_children():
        widget.destroy()
    # Recreate the initial screen
    create_initial_screen()

def create_initial_screen():
    global label
    frame = Frame(window)
    frame.pack(expand=True, fill='both')

    # Create a button that increments the count
    button = Button(frame, text="brenda++", command=click, font=("Comic Sans", 24), width=20, height=5)
    button.pack(expand=True, pady=10)

    # Create a label to display the count
    label = Label(frame, text="Né Brenda?: 0", font=("Comic Sans", 24))
    label.pack(expand=True)

    # Create a button to end the day
    end_button = Button(frame, text="Encerrar dia", command=end_day, font=("Comic Sans", 24), width=15, height=3)
    end_button.pack(expand=True, pady=10)

# Create the main window
window = Tk()
window.title("brenda++")

# Initialize the initial screen
create_initial_screen()

# Start the main event loop
window.mainloop()
