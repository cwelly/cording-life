using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class mainMenuManagement : MonoBehaviour {
    public GameObject start;
    public GameObject explain;
    public GameObject tutorial;
    public GameObject quit;
    public GameObject sound;


    private int selection;


    // Use this for initialization
    void Start () {
        selection = 0;
        start.SetActive(true);
        explain.SetActive(false);
        tutorial.SetActive(false);
        quit.SetActive(false);
	}
	
	// Update is called once per frame
	void Update () {
        if (selection == 0)
        {
            start.SetActive(true);
            quit.SetActive(false);
        }
        else if (selection == 1)
        {
            explain.SetActive(true);
            start.SetActive(false);
        }
        else if (selection == 2) {
            explain.SetActive(false);
            tutorial.SetActive(true);
        }
        else if (selection == 3)
        {
            tutorial.SetActive(false);
            quit.SetActive(true);
        }
        if (OVRInput.GetUp(OVRInput.Button.PrimaryTouchpad) || Input.GetKeyUp(KeyCode.Z))
        {
            selection = (selection + 1) % 4;
            sound.SendMessage("startSound");
        }
        if ((OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space)) && selection == 0)
        {
            SceneManager.LoadScene("Loading");
        }
        else if ((OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space)) && selection == 1)
        {
            SceneManager.LoadScene("Explain");
        }
        else if ((OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space)) && selection == 2)
        {
            SceneManager.LoadScene("Loading2");
        }
        else if ((OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space)) && selection == 3)
        {
            Application.Quit();
        }
    }
}
